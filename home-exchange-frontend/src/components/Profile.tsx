import React, { useEffect, useState } from 'react'
import Header from './Header'
import { defaultUser, IUserDto } from '../helpers/interfaces/interfacesDTO'
import { getUser } from '../helpers/UserHelper'
import ModifyUserPopup from './ModifyUserPopUp'

const Profile = () => {

    const [user, setUser] = useState<IUserDto>(defaultUser)
    const [isModifyPopUpOpen, setIsPopUpOpen] = useState<boolean>(false)

    useEffect(() => {
        getUser()
            .then(res => {
                console.log(res)
                setUser(res)
            })
    }, [])

    return (
        <>
            <Header />
            <section className="App h-screen w-full flex justify-center items-center bg-green-100">
                <div className="mt-16 flex flex-col items-center w-10/12 max-w-screen-2xl h-4/5 rounded-md bg-white pb-8" >
                    <div className="flex items-center justify-center w-11/12 h-3/5 pt-24 relative">
                        {user.profilePictureUrl != null ?
                            <div className="relative w-44 h-44">
                                <img className="rounded-full border border-gray-100 shadow-sm h-full" src={user.profilePictureUrl} alt="user image" />
                            </div>
                            :
                            <div className="flex h-full bg-gray-200 w-60 justify-center items-center">
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-16 w-16" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z" />
                                </svg>
                            </div>
                        }
                        {user.admin &&
                            <svg xmlns="http://www.w3.org/2000/svg" className="h-10 w-10 absolute top-8 right-0 fill-current text-green-600" viewBox="0 0 20 20" fill="currentColor">
                                <path fill-rule="evenodd" d="M6.267 3.455a3.066 3.066 0 001.745-.723 3.066 3.066 0 013.976 0 3.066 3.066 0 001.745.723 3.066 3.066 0 012.812 2.812c.051.643.304 1.254.723 1.745a3.066 3.066 0 010 3.976 3.066 3.066 0 00-.723 1.745 3.066 3.066 0 01-2.812 2.812 3.066 3.066 0 00-1.745.723 3.066 3.066 0 01-3.976 0 3.066 3.066 0 00-1.745-.723 3.066 3.066 0 01-2.812-2.812 3.066 3.066 0 00-.723-1.745 3.066 3.066 0 010-3.976 3.066 3.066 0 00.723-1.745 3.066 3.066 0 012.812-2.812zm7.44 5.252a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd" />
                            </svg>
                        }
                    </div>

                    <div className="my-8 flex w-11/12 text-5xl items-center justify-center">
                        <h1>{user.firstname} {user.lastname}</h1>
                        <button onClick={() => setIsPopUpOpen(true)}>
                            <svg xmlns="http://www.w3.org/2000/svg" className="ml-2 h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
                            </svg>
                        </button>
                    </div>

                    <div className="h-2 my-3 w-11/12 bg-gray-500"></div>

                    <div className="flex flex-col w-11/12 text-3xl h-full items-start mt-8">
                        <h1 className="pr-16 my-8"><span className="pr-4 font-bold text-green-300">Email</span>{user.email}</h1>
                        {user.phoneNumber &&
                            <h1><span className="pr-4 font-bold text-green-300">Phone number</span>{user.phoneNumber}</h1>
                        }

                    </div>
                </div>
                {isModifyPopUpOpen && <ModifyUserPopup user={user} setUser={setUser} setIsPopupOpen={setIsPopUpOpen}/>}
            </section>
        </>
    )

}

export default Profile