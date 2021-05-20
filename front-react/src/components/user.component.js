import React, {Component} from "react";
import UserDataService from "../services/user.services";

export default class User extends Component {
    constructor(props) {
        super(props);
        this.onChangeLastname = this.onChangeLastname.bind(this);
        this.onChangeFirstName = this.onChangeFirstName.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.getUser = this.getUser.bind(this);
        this.updateUser = this.updateUser.bind(this);
        this.deleteUser = this.deleteUser.bind(this);

        this.state = {
            currentUser: {
                id: null,
                lastName: "",
                firstName: "",
                email: ""
            },
            message: ""
        };
    }

    componentDidMount() {
        this.getUser(this.props.match.params.id);
    }

    onChangeLastname(e){
        const lastName = e.target.value;

        this.setState(function(prevState) {
            return {
                currentUser: {
                    ...prevState.currentUser,
                    lastName: lastName
                }
            };  
        });
    }

    onChangeFirstName(e){
        const firstName = e.target.value

        this.setState(prevState => ({
            currentUser: {
                ...prevState.currentUser,
                firstName: firstName
            }
        }));
    }

    onChangeEmail(e){
        const email = e.target.value

        this.setState(prevState => ({
            currentUser: {
                ...prevState.currentUser,
                email: email
            }
        }));
    }

    getUser(id) {
        UserDataService.get(id)
        .then(response => {
            this.setState({
                currentUser: response.data
            });
            console.log(response.data);
        })
        .catch(e => {
            console.log(e)
        });
    }

    updateUser() {
        UserDataService.update(
            this.state.currentUser.id,
            this.state.currentUser
        )
        .then(response => {
            console.log(response.data);
            this.setState({
                message: "The user was updated successfully !"
            });
        })
        .catch(e => {
            console.log(e);
        });
    }

    deleteUser(){
        UserDataService.delete(this.state.currentUser.id)
            .then(response => {
                console.log(response.data);
                this.props.history.push('/users')
            })
            .catch(e => {
                console.log(e);
            })
    }

    render() {
        return(
            <div>
                {currentUser ? (
                    <div className="edit-form">
                        <h4>User</h4>
                        <form>
                            <div className="form-group">
                                <label htmlFor="lastName">Last name</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="lastName"
                                    value={currentUser.lastName}
                                    onChange={this.onChangeLastname}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="firstName">First name</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="firstName"
                                    value={currentUser.firstName}
                                    onChange={this.onChangeFirstName}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="email"
                                    value={currentUser.email}
                                    onChange={this.onChangeEmail}
                                />
                            </div>
                        </form>

                        <button
                            className="badge badge-danger mr-2"
                            onClick={this.deleteUser}
                        >
                            delete
                        </button>

                        <button
                            type="submit"
                            className="badge badge-success"
                            onClick={this.updateUser}
                        >
                            update
                        </button>
                        <p>{this.state.message}</p>
                    </div>
                ) : (
                    <div>
                        <br/>
                        <p>If you want details on a User, click on it ! ;)</p>
                    </div>
                )}
            </div>
        );
    }
} 