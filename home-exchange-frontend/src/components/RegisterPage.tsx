import axios from "axios";
import { useState } from "react";
import { Redirect } from "react-router";
import { IRegisterDto, IUserDto } from "../helpers/interfaces/interfacesDTO";

interface IProps {
    setUser: (user: IUserDto) => void; 
}

const RegisterPage = (props: IProps) => {

    const [firstname, setFirstname] = useState<string>("");
    const [lastname, setLastname] = useState<string>("");
    const [phoneNumber, setPhoneNumber] = useState<string>("");
    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [confirmPassword, setConfirmPassword] = useState<string>("");
    const [message, setMessage] = useState<string>("");
    const [isRegister, setIsRegister] = useState<boolean>(false);

    const registerUser = () => {
        if(email === "" || password=== "" || firstname=== "" ||lastname=== "" ){
            setMessage('Something went wrong please fill all the fields')
        } else if(password !== confirmPassword){
            setMessage("Your passwords must be the same")
        } else {
            const createUser: IRegisterDto = {email, password, phoneNumber, firstname, lastname};
            axios
                .post<IUserDto>('http://localhost:8080/register', createUser)
                .then(response => {
                    console.log(response.data)
                    props.setUser(response.data);
                    setMessage("");
                    console.log("User created");
                    setIsRegister(true);
                })
                .catch(err => setMessage("Something went wrong"))
        }
    }

    return (
        <section className="App h-screen w-full flex justify-center items-center bg-green-300">
            <div className="w-full max-w-xl bg-gray-800">
                <form action="" className="bg-white shadow-md rounded px-8 py-8 pt-8">
                    <div className="grid gap-x-10 gap-y-4 grid-cols-2">
                        <div className="px-4 pb-4">
                            <label htmlFor="firstName" className="text-sm block font-bold  pb-2">FIRST NAME</label>
                            <input type="text" name="firstName" placeholder="Joris" required onChange={(e:React.FormEvent<HTMLInputElement>) => setFirstname(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4">
                            <label htmlFor="lastName" className="text-sm block font-bold  pb-2">LAST NAME</label>
                            <input type="text" name="lastName" placeholder="Baudchon" required onChange={(e:React.FormEvent<HTMLInputElement>) => setLastname(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>

                        <div className="px-4 pb-4">
                            <label htmlFor="phoneNumber" className="text-sm block font-bold  pb-2">PHONE NUMBER</label>
                            <input type="tel" name="phoneNumber" placeholder="0684956215" pattern="[0-9]{10}" onChange={(e:React.FormEvent<HTMLInputElement>) => setPhoneNumber(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4">
                            <label htmlFor="email" className="text-sm block font-bold  pb-2">EMAIL ADDRESS</label>
                            <input type="email" name="email" required onChange={(e:React.FormEvent<HTMLInputElement>) => setEmail(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " placeholder="Johnbull@example.com" />
                        </div>
                        <div className="px-4 pb-4">
                            <label htmlFor="password" className="text-sm block font-bold pb-2">PASSWORD</label>
                            <input type="password" name="password" required onChange={(e:React.FormEvent<HTMLInputElement>) => setPassword(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300" placeholder="Enter your password" />
                        </div>
                        <div className="px-4 pb-4">
                            <label htmlFor="confirmPassword" className="text-sm block font-bold pb-2">CONFIRM PASSWORD</label>
                            <input type="password" name="confirmPassword" required onChange={(e:React.FormEvent<HTMLInputElement>) => setConfirmPassword(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300" placeholder="Confirm your password" />
                        </div>
                    </div>
                    {
                        <p className="text-lg text-red-500">{message}</p>
                    }
                    <div className="flex justify-around mt-10">
                        <button onClick={registerUser} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button">Register</button>
                    </div>
                    {isRegister && <Redirect to="/Booking" />}
                </form>
            </div>
        </section>
    );
}

export default RegisterPage;