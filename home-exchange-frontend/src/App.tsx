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
import { defaultUser, IUserDto } from "./helpers/interfaces/interfacesDTO";
import { getUser } from "./helpers/UserHelper";

function App() {

  const [user, setUser] = useState<IUserDto>(defaultUser) //1 dans interface pour tester

  useEffect(() => {
      getUser()
        .then(response => setUser(response))
  }, [])

  return (
    <Router>
      <Switch>
        <Route exact path='/'>
          <LoginPage setUser={setUser}/>
        </Route>
        <Route path="/register">
          <RegisterPage setUser={setUser}/>
        </Route>
        <Route path="/Booking">
          <Booking />
        </Route>
        <Route path="/MyHousings">
          <MyHousings userId={user.id}/>
        </Route>
        <Route path="/House/:id">
          <House userId={user.id}/>
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
