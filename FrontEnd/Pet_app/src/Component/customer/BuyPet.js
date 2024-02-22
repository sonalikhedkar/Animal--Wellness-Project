import React, { useState } from "react";
import "./home.css";
import { Component } from "react";
import ApiService from "../../service/ApiService";
import { Link } from "react-router-dom";
import Swal from "sweetalert2";
//import ListAllBreeds from "./ListAllBreeds";

class BuyPet extends Component {
  constructor(props) {
    super(props);
    this.state = {
      breed: [],
      message: "",
      role: "",
    };
  }

  componentDidMount() {
    ApiService.fetchPet().then((resp) => {
      this.setState({ breed: resp.data });
      console.log(this.state.breed);
    });

    
    let loginData = localStorage.getItem("loginDetails")
      ? localStorage.getItem("loginDetails")
      : null;
    if (loginData) {
      loginData = JSON.parse(loginData);
      this.setState({ role: loginData.role });
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

  
  buypet = (b1) => {
    let loginData = localStorage.getItem("loginDetails")
      ? localStorage.getItem("loginDetails")
      : null;

    if (loginData) {
      loginData = JSON.parse(loginData);
      if (loginData.id) {
        let cartData = { customerId: loginData.id, breedId: b1.id };
        ApiService.addPetToCardAPI(cartData)
          .then((resp) => {
            this.setState({ message: "Item Added to Cart !!!" });
            Swal.fire({
              position: "center",
              icon: "success",
              title: "pet added to your cart successfully...",
              showConfirmButton: false,
              timer: 1500,
            });
          })
          .catch((err) => {
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: err.resp.data.message,
              footer: '<a href="">Why do I have this issue?</a>',
            });
          });
      }
    } else {
      alert("please login");
      window.location.href = "/login";
    }
  };


  render() {
    return (
      <>

        <h2><i>Pets Available for Sell</i></h2>
        <div className="d-flex flex-wrap  justify-content-center align-items-center mt-4">
          {this.state.breed.map((b1) => (
            <div
              className="container m-2"
              key={b1.id}
              style={{ width: "25rem" }}
            >
              <div
                className="card mb-3 p-2 "
                style={{
                  height: "40rem",
                  boxShadow:
                    " 2px 4px 0 rgba(0, 0, 0, 0.2), 0 3px 10px 0 rgba(0, 0, 0, 0.404)",
                }}
              >
                <div>
                  <img
                    className="card-img-top "
                    src={b1.imgUrl}
                    style={{ width: "200px", height: "200px" }}
                    alt="Card image cap"
                  />
                </div>
                <div className="card-body">
                  <h5 className="card-title"><i>{b1.name}</i></h5>
                  <p className="card-text"> <b>Type:</b>{b1.type}</p>
                  <p className="card-text"> <b>Breed:</b>{b1.breed}</p>
                  <p className="card-text"> <b>Gender:</b>{b1.gender}</p>
                  <p className="card-text"> <b>Age:</b>{b1.age}</p>
                  <p className="card-text"><b>Weight:</b> {b1.weight}</p>
                  <p className="card-text"><b>Description:</b> {b1.description}</p>
                  <p className="card-text"><b>Price:</b> {b1.price}</p>
                  
                  <div className="col-10"></div>
                  <hr />

                  <div className="row d-flex justify-content-around ">
                    {this.state.role == "admin" ? (
                      <></>
                    ) : (
                      <div className="col-5" style={{ width: "50%" }}>
                        <button
                          className="  btn btn-info w-100"
                          onClick={() => this.buypet(b1)}
                        >
                          Buy
                        </button>
                      </div>
                    )}
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
        
      </>
    );
  }
}
export default BuyPet;