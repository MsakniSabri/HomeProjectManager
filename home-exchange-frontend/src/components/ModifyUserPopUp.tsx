import { useState } from "react";
import { IRegisterDto, IUpdateUserDto, IUserDto } from "../helpers/interfaces/interfacesDTO"
import { updateUser } from "../helpers/UserHelper";

interface IProps {
    user: IUserDto,
    setUser: (user: IUserDto) => void;
    setIsPopupOpen: (boolean: boolean) => void;
}

const ModifyUserPopup = (props: IProps) => {

    const [firstname, setFirstname] = useState<string>(props.user.firstname)
    const [lastname, setLastname] = useState<string>(props.user.lastname)
    const [email, setEmail] = useState<string>(props.user.email)
    const [phoneNumber, setPhoneNumber] = useState<string>(props.user.phoneNumber)
    const [password, setPassword] = useState<string>("")
    const [message, setMessage] = useState<string>("")

    const closePopup = () => {
        if (password != "") {
            const id = props.user.id;
            const admin = props.user.admin;
            const profilePictureUrl = props.user.profilePictureUrl
            const housings = props.user.housings
            let user: IUpdateUserDto = { id, email, phoneNumber, password, firstname, lastname, admin, housings, profilePictureUrl };
            props.setIsPopupOpen(false);

            updateUser(user)
                .then(response => props.setUser(response))
        }else {
            setMessage("You need to fill your password")
        }

    }

    return (
        <section className="App h-screen w-full flex justify-center absolute top-0 right-0 items-center bg-green-100 bg-opacity-70">
            <div className="w-full h-1/2 max-w-xl bg-gray-800 relative">
                <button className="absolute top-2 right-2" onClick={() => props.setIsPopupOpen(false)}>
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12" />
                    </svg>
                </button>
                <form action="" className="h-full bg-white shadow-md rounded px-8 py-8 pt-8">
                    <div className="flex flex-col h-4/5">
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">FIRSTNAME</label>
                            <input type="text" name="firstname" value={firstname} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setFirstname(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">LASTNAME</label>
                            <input type="text" name="lastname" value={lastname} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setLastname(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">EMAIL</label>
                            <input type="email" name="email" value={email} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setEmail(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">PHONE NUMBER</label>
                            <input type="tel" pattern="[0-9]{10}" name="phoneNumber" value={phoneNumber} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setPhoneNumber(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">PASSWORD</label>
                            <input type="password" name="password" value={password} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setPassword(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                    </div>
                    {
                        <p className="text-lg text-red-500">{message}</p>
                    }
                    <div className="flex justify-around mt-10">
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button" onClick={closePopup}>Register</button>
                    </div>
                </form>
            </div>
        </section >
    )

}

export default ModifyUserPopup