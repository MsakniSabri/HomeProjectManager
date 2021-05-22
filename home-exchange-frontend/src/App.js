import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Route, Router, Switch } from "react-router";
import { Link } from "react-router-dom";

import AddUser from "./components/add-user.component";
import User from "./components/user.component";
import UserList from "./components/user-list.component";

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href="/users" className="navbar-brand">
              bezKoder
            </a>
            <div className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/users"} className="nav-link">
                  Users
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Add
                </Link>
              </li>
            </div>
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/users"]} component={UserList} />
              <Route exact path="/add" component={AddUser} />
              <Route exact path="/users/:id" component={User} />
            </Switch>
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
