import React, { Component } from 'react'
import ApiService from '../../service/admin/ApiService';

class AppFeedbackList extends Component {
    constructor(props) {
        super(props);
        this.state = {
          users: [],
          message: "default message",
        };
        this.reloadUserList = this.reloadUserList.bind(this);
      }

      componentDidMount() {
        this.reloadUserList();
      }

      reloadUserList() {
        ApiService.fetchAllCustomers()
          .then((resp) => {
            this.setState({ users: resp.data });
            console.log(this.state.users);
          })
          .catch((err) => {
            console.error("in err ", err.response.data);
            alert(err.response.data.message);
          });
      }

    render() {
        return (
            <div>
                <table class="table">
          <caption>Customers FeedBack</caption>
          <thead>
            <tr>
              {/* <th scope="col">ID</th> */}
              <th scope="col">FirstName</th>
              <th scope="col">LastName</th>
              <th scope="col">Description</th>
              <th scope="col">Rating</th>
            </tr>
          </thead>
          <tbody>
          {this.state.users.map((user) => (
            <tr>
                {/* <td>{user.id}</td> */}
                <td>{user.customer.firstName}</td>
                <td>{user.customer.lastName}</td>
                <td>{user.description}</td>
                <td>{user.rating} Star</td>
                </tr>
            ))}
          </tbody>
        </table>
            </div>
        );
    }
}

export default AppFeedbackList;