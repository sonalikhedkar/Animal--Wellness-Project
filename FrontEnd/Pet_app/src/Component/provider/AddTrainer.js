import { Component } from "react";
import ApiService from "../../service/admin/ApiService";
import Swal from "sweetalert2";
class AddTrainer extends Component{
    constructor(props) {
        super(props);
        this.state = {
            id:"",
            firstname: "",
            lastname:"",
            experience:"",
            fees:"",
            contact:"",
            address:"",
            email:"",
            message: null,
            message: "",
            formErrors: {},
        };
        this.saveTrainer = this.saveTrainer.bind(this);

      }
   onChange = (e) => this.setState({ [e.target.name]: e.target.value });

   onValueChange = (event) =>
    this.setState({
      category: event.target.value,
    });



  handleFormValidation() {
    const { firstname, lastname, experience, fees,contact,address,email} = this.state;
    let formErrors = {};
    let formIsValid = true;
    if (!firstname) {
      formIsValid = false;
      formErrors["firstnameErr"] = "*first Name is required.";
    }
    if (!lastname) {
      formIsValid = false;
      formErrors["lastnameErr"] = "*Last Name is required.";
    }
    if (!email) {
      formIsValid = false;
      formErrors["emailIdErr"] = "*Email id is required.";
    } else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
      formIsValid = false;
      formErrors["emailIdErr"] = "*Invalid email id.";
    }
    if (!experience) {
      formIsValid = false;
      formErrors["experienceErr"] = "*Experience is required.";
    }
    if (!fees) {
      formIsValid = false;
      formErrors["FeesErr"] = "*enter the price.";
    } else if (!/^\d{0,8}[.]?\d{1,4}$/.test(fees)) {
      formIsValid = false;
      formErrors["FeesErr"] = "*InvalidPrice.";
    }
    if (!contact) {
      formIsValid = false;
      formErrors["contactErr"] = "*Phone number is required.";
    } else {
      var mobPattern = /^(?:(?:\\+|0{0,2})91(\s*[\\-]\s*)?|[0]?)?[789]\d{9}$/;
      if (!mobPattern.test(contact)) {
        formIsValid = false;
        formErrors["contactErr"] = "*Invalid phone number.";
      }
    }
    if (!address) {
      formIsValid = false;
      formErrors["AddErr"] = "*Description is required.";
    }

    this.setState({ formErrors: formErrors });
    return formIsValid;
  }

  saveTrainer = (e) => {
    e.preventDefault();
    if (this.handleFormValidation()) {
      let trainer = {
        firstname: this.state.firstname,
        lastname: this.state.lastname,
        fees: this.state.fees,
        address: this.state.address,
        contact: this.state.contact,
        experience:this.state.experience,
        email:this.state.email
        
      };

      ApiService.addTrainer(trainer)
        .then((resp) => {
          this.setState({ message: "Trainer added successfully." });
          this.setState({
            id: resp.data.id,
          });
          console.log("id" + this.state.id);
          Swal.fire({
            position: "center",
            icon: "success",
            title: "trainer added successfully...",
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
    }
  };

render() {
    const {  message } = this.state;
    const { firstnameErr, lastnameErr, FeesErr, addressErr, contactErr, experienceErr,emailIdErr} = this.state.formErrors;
    return (
      <div 
      className="carousalimage7 d-flex justify-content-center"

      >
        <div
          className="bg-white m-4 p-4 border "
          style={{
            
            height: "700px",
            width: "550px",
            boxShadow:
              " 2px 4px 0 rgba(0, 0, 0, 0.2), 0 3px 10px 0 rgba(0, 0, 0, 0.404)",
          }}
        >
          <h2 className="text-center">Add Trainer</h2>
          <form>
            <div className="d-flex flex-wrap flex-column justify-content-between">
              <div className="form-group">
                <label>
                  <span className="text-danger">*</span>first Name:
                </label>
                <input
                  type="text"
                  placeholder="firstname"
                  name="firstname"
                  className={
                    firstnameErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.firstname}
                  onChange={this.onChange}
                />
                {firstnameErr && (
                  <div
                    className="text-start"
                    style={{ color: "red", fontSize: "12px" }}
                  >
                    {firstnameErr}
                  </div>
                  
                )}
                </div>
              </div>
              <div className="d-flex flex-wrap flex-column justify-content-between">
              <div className="form-group">
                <label>
                  <span className="text-danger">*</span>last Name:
                </label>
                <input
                  type="text"
                  placeholder="lastname"
                  name="lastname"
                  className={
                    lastnameErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.lastname}
                  onChange={this.onChange}
                />
                {lastnameErr && (
                  <div
                    className="text-start"
                    style={{ color: "red", fontSize: "12px" }}
                  >
                    {lastnameErr}
                  </div>
                )}
              </div>

              <div className="form-group">
                <label>
                  <span className="text-danger">*</span>Email id:
                </label>
                <input
                  type="email"
                  placeholder="email id"
                  name="email"
                  className={
                    emailIdErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.email}
                  onChange={this.onChange}
                />
                {emailIdErr && (
                  <div
                    className="text-start"
                    style={{ color: "red", fontSize: "12px" }}
                  >
                    {emailIdErr}
                  </div>
                )}
              </div>

              <div className="row">
                <div className="form-group col-6">
                <label htmlFor="timeInput">
                  <span className="text-danger">*</span>Experience:
                </label>
                <input
                  placeholder="Experience"
                  type="number"
                  name="experience"
                  className={
                    experienceErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.experience}
                  onChange={this.onChange}
                />
                </div>
               
             
                </div>
                

              <div className="form-group">
                <label>
                  <span className="text-danger">*</span>Fees:
                </label>
                <input
                type="number"
                  placeholder="fees"
                  name="fees"
                  className={
                    FeesErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.fees}
                  onChange={this.onChange}
                />
                {FeesErr && (
                  <div
                    className="text-start"
                    style={{ color: "red", fontSize: "12px" }}
                  >
                    {FeesErr}
                  </div>
                )}
              </div>

              

             
              <div className="form-group">
                <label>
                  <span className="text-danger">*</span>Address:
                </label>
                <input
                  placeholder="address"
                  name="address"
                  className={
                    addressErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.address}
                  onChange={this.onChange}
                />
                {addressErr && (
                  <div
                    className="text-start"
                    style={{ color: "red", fontSize: "12px" }}
                  >
                    {addressErr}
                  </div>
                )}
              </div>
              

                <div className="form-group">
                <label>
                  <span className="text-danger">*</span>Contact:
                </label>
                <input
                   type="mob"
                   placeholder="contact"
                  name="contact"
                  className={
                    contactErr ? "form-control showError" : "form-control"
                  }
                  value={this.state.contact}
                  onChange={this.onChange}
                />
                </div>

              <button className="btn btn-success mt-4" onClick={this.saveTrainer}>
                Save
              </button>
            </div>
          </form>
        </div>
      </div>
    );
  }
}
export default AddTrainer;