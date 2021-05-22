import React, { Component } from "react";
import UserDataService from "../services/user.services";
import { Link } from "react-router-dom";

export default class UserList extends Component {
    constructor(props) {
        super(props);
        this.onChangeSearchLastName = this.onChangeSearchLastName.bind(this);
        this.retrieveUsers = this.retrieveUsers.bind(this);
        this.refreshList = this.refreshList.bind(this);
        this.setActiveUser = this.setActiveUser(this);
        this.removeAllUsers = this.removeAllUsers.bind(this);
        this.searchLastName = this.searchLastName.bind(this);

        this.state = {
            users: [],
            currentUser: null,
            currentIndex: -1,
            searchLastName: ""
        };
    }

    componentDidMount(){
        this.retrieveUsers();
    }

    onChangeSearchLastName(e){
        const searchLastName = e.target.value;

        this.setState({
            searchLastName: searchLastName
        });
    }

    retrieveUsers(){
        UserDataService.getAll()
            .then(response => {
                this.setState({
                    users: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    refreshList(){
        this.retrieveUsers();
        this.setState({
            currentUser: null,
            currentIndex: -1
        });
    }

    setActiveUser(user, index) {
        this.setState({
            currentUser: user,
            currentIndex: index
        });
    }

    removeAllUsers(){
        UserDataService.deleteAll()
            .then(response => {
                console.log(response.data);
                this.refreshList();
            })
            .catch(e => {
                console.log(e);
            });
    }

    searchLastName(){
        UserDataService.findByLastName(this.state.searchLastName)
            .then(response => {
                this.setState({
                    users: response.data
                });
                console.log(response.data)
            })
            .catch(e => {
                console.log(e);
            })
    }

    render() {
        const { searchLastName, users, currentUser, currentIndex } = this.state;

        return(
            <div className="list row">
                <div className="col-md-8">
                    <div className="input-grou^p mb-3">
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Search by last name"
                            value={searchLastName}
                            onChange={this.onChangeSearchLastName}
                        />
                        <div className="input-group-append">
                            <button
                                className="btn btn-outline-secondary"
                                type="button"
                                onClick={this.searchLastName}
                            >
                                Search
                            </button>
                        </div>
                    </div>
                </div>

                <div className="col-md-6">
                    <h4>Users List</h4>

                    <ul className="list-group">
                        {users && users.map((user, index) => (
                            <li
                                className={"list-group-item " + (index === currentIndex ? "active" : "")}
                                onClick={() => this.setActiveUser(user, index)}
                                key={index}
                            >
                                {user.lastName}
                            </li>
                        ))}
                    </ul>

                    <button
                        className="m-3 btn btn-sm btn-danger"
                        onClick={this.removeAllUsers}
                    >
                        Remove All
                    </button>
                </div>

                <div className="col-md-6">
                    {currentUser ? (
                        <div>
                            <h4>User</h4>
                            <div>
                                <label>
                                    <strong>Last name:</strong>
                                </label>{" "}
                                {currentUser.lastName}
                            </div>
                            <div>
                                <label>
                                    <strong>First name:</strong>
                                </label>{" "}
                                {currentUser.firstName}
                            </div>
                            <div>
                                <label>
                                    <strong>Email:</strong>
                                </label>{" "}
                                {currentUser.email}
                            </div>

                            <Link
                                to={"/users/" + currentUser.id}
                                className="badge badge-warning"
                            >
                                Edit
                            </Link>
                        </div>
                    ) : (
                        <div>
                            <br />
                            <p> If you want details about a user, click on it ! ;)</p>
                        </div>
                    )}
                </div>
            </div>
        );
    }
}