import React, { Component } from "react";
import UserDataService from "../services/user.services";

export default class AddUser extends Component {
    constructor(props) {
        super(props);
        this.onChangeFirstName = this.onChangeFirstName.bind(this);
        this.onChangeLastName = this.onChangeLastName.bind(this);
        this.onChangeEmail = this.onChangeEmail.bind(this);
        this.saveUser = this.saveUser.bind(this);
        this.newUser = this.newUser.bind(this);

        this.state = {
            id: null,
            firsName: "",
            lastName: "",
            email: "",

            created: false
        };
    }

    onChangeFirstName(e){
        this.setState({
            firsName: e.target.value
        });
    }

    onChangeLastName(e){
        this.setState({
            lastName: e.target.value
        })
    }

    onChangeEmail(e){
        this.setState({
            email: e.target.value
        })
    }

    saveUser(){
        var data = {
            firsName: this.state.firsName,
            lastName: this.state.lastName,
            email: this.state.lastName,
        };

        UserDataService.create(data)
            .then(response => {
                this.setState({
                    id: response.data.id,
                    firsName: response.data.firsName,
                    lastName: response.data.lastName,
                    email: response.data.email,

                    created: true
                });
                console.log(response.data)
            })
            .catch(e => {
                console.log(e);
            });
    }

    newUser(){
        this.setState({
            id: null,
            firsName: "",
            lastName: "",
            email: "",

            created: true
        });
    }

    render(){
        return (
            <div className="submit-form">
                {this.state.created ? (
                    <div>
                        <h4>You created successfully !</h4>
                        <button className="btn btn-success" onClick={this.newUser}>
                            Add
                        </button>
                    </div>
                ) : (
                    <div>
                        <div className="form-group">
                            <label htmlFor="firstName">First name</label>
                            <input
                                type="text"
                                className="form-control"
                                id="firstName"
                                required
                                value={this.state.firsName}
                                onChange={this.onChangeFirstName}
                                name="firstName"
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="lastName">Last name</label>
                            <input
                                type="text"
                                className="form-control"
                                id="lastName"
                                required
                                value={this.state.lastName}
                                onChange={this.onChangeLastName}
                                name="lastName"
                            />
                        </div>

                        <div className="form-group">
                            <label htmlFor="email">Email address</label>
                            <input
                                type="email"
                                className="form-control"
                                id="email"
                                required
                                value={this.state.email}
                                onChange={this.onChangeEmail}
                                name="email"
                            />
                        </div>

                        <button onClick={this.saveUser} className="btn btn-success">
                            submit
                        </button>
                    </div>
                )}
            </div>
        )
    }

}