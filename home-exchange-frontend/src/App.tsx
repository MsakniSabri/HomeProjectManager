import { useEffect, useState } from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import './App.css';
import Booking from './components/Booking'
import House from "./components/House";
import LoginPage from "./components/LoginPage";
import MyHousings from "./components/MyHousings";
import RegisterPage from "./components/RegisterPage";
import { IUserDto } from "./helpers/interfaces/interfacesDTO";

function App() {

  const [user, setUser] = useState<IUserDto>({id: 0, email: '', phoneNumber: 'string', firstname: '', lastname: '', profilePictureUrl: '', admin: false, housings: []})

  return (
    <Router>
      <Switch>
        <Route exact path='/'>
          <LoginPage setUser={setUser}/>
        </Route>
        <Route path="/register">
          <RegisterPage />
        </Route>
        <Route path="/Booking">
          <Booking />
        </Route>
        <Route path="/MyHousings">
          <MyHousings/>
        </Route>
        <Route path="/House/:id">
          <House/>
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
