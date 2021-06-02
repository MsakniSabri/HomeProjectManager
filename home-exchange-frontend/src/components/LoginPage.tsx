import React, { useEffect, useState } from 'react'
import {Redirect } from 'react-router-dom';
import {isLoggedIn} from '../helpers/UserHelper';

const LoginPage = () => {

    const [login, setLogin] = useState<boolean>(false);

    const isLoginIsValid = () => {
        setLogin(isLoggedIn())
    }

    return (
        <section className="App h-screen w-full flex justify-center items-center bg-lime-200">
            <div className="w-full max-w-md bg-gray-800" >
                <form action="" className=" bg-white shadow-md rounded px-8 py-8 pt-8">
                    <div className="px-4 pb-4">
                        <label htmlFor="email" className="text-sm block font-bold  pb-2">EMAIL ADDRESS</label>
                        <input type="email" name="email" id="" className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " placeholder="Johnbull@example.com" />
                    </div>
                    <div className="px-4 pb-4">
                        <label htmlFor="password" className="text-sm block font-bold pb-2">PASSWORD</label>
                        <input type="password" name="email" id="" className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300" placeholder="Enter your password" />
                    </div>
                    <div className="flex justify-around">
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button" onClick={isLoginIsValid}>Sign In</button>
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button">Register</button>
                    </div>
                </form>
            </div>
            {login && <Redirect to="/login" />}
        </section>
    );
}

export default LoginPage;
