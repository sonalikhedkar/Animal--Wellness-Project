import React, { useState } from 'react';
import { Component } from "react";
import Swal from "sweetalert2";
import ApiService from '../../service/admin/ApiService';
import "../CSS/AppForm.css"

class AppFeedbackForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
          message: "",
          appfeedRating: "",
          userID:"",
          appfeedDesc: '',
          formErrors: {},
        };
        this.submitfeedback = this.submitfeedback.bind(this);
      }

      componentDidMount(){
        let loginData = localStorage.getItem("loginDetails")
        ? localStorage.getItem("loginDetails")
        : null;
          if (loginData) {
        loginData = JSON.parse(loginData);
        this.setState({ userID: loginData.id });
      }
      setTimeout(() => {
          const reloadCount = sessionStorage.getItem("reloadCount");
          if (reloadCount < 1) {
            sessionStorage.setItem("reloadCount", String(reloadCount + 1));
            window.location.reload();
          } else {
            sessionStorage.removeItem("reloadCount");
          }
        }, 800);
      }

    handleInputChange=(e) => this.setState({ [e.target.name]: e.target.value });

    handleStarClick = (ratingvalue) => {
    this.setState ({appfeedRating : ratingvalue})  
    console.log(`This is the selected Rating ${this.state.appfeedRating}`); 
    };

    submitfeedback = (event) => {  
      event.preventDefault();
        let details = {
          rating : this.state.appfeedRating,
          description : this.state.appfeedDesc,
          customer :{ id: this.state.userID} ,
        };
        console.log(details);

        ApiService.addFeedback(details)
        .then((resp) => {
          this.setState({ message: "FeedBack Added Successfully." });
          this.setState({
            id: resp.data.id,
          });
          console.log("id" + this.state.id);
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Thanks For Your FeedBack...",
            showConfirmButton: false,
            timer: 1500,
          });
        })
        .catch((err) => {
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: err.response.data.message,
            footer: '<a href="">Why do I have this issue?</a>',
          });
          this.props.history.push("/");
        });

      };

      render() {
        const ratingIcons = ['★', '★', '★', '★', '★'];
            return (
            <div className="app-box app-feedback-form " style={{alignSelf:'center',margin:'auto',marginTop:'10px',marginBottom:"10px"}}>
                <h2 className="app-heading1">Application Feedback</h2><br></br><br></br>
                    <form  className="app-feed-form">
                         <label className="label">
                   Rating:
                    <div className="app-star-rating">
                        {[1, 2, 3, 4, 5].map((value) => (
                        <span
                            key={value}
                            className={`app-star ${value <= this.state.appfeedRating ? 'filled' : ''}`}
                            // className={`app-star ${value <= formData.appfeedRating ? 'filled' : ''}`}
                            onClick={() => this.handleStarClick(value)}
                            
                        >
                            ★
                        </span>
                        ))}
                        </div>
                        </label>
                        <br />
                        <label className="label">
                            Description:
                            <textarea
                                name="appfeedDesc"
                                value={this.state.appfeedDesc} 
                                onChange={this.handleInputChange} 
                                rows="6"
                                className={this.state.appfeedDesc.length ? '': 'error'}
                                required 
                            />
                        </label>
                        <br />
                        <label className="label">
                            User ID:
                            <input
                            name="userId"
                            readOnly
                            value={this.state.userID}
                                type="number"                                                       
                            />
                        </label>
                        <br />
                        <center><button type="submit" className="button"
                        onClick={this.submitfeedback}>Submit Feedback</button></center>
                    </form>
            </div>        
        );
    }
}

export default AppFeedbackForm;