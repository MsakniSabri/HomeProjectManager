import { useState, useEffect } from 'react';
import { getAllHouses } from "../helpers/HousesHelper";
import { IHousingDto } from "../helpers/interfaces/interfacesDTO";
import Header from "./Header";

const Booking = () => {

    const [housings, setHousings] = useState<IHousingDto[]>([])

    useEffect(() => {
        getAllHouses()
            .then(response => setHousings(response))
    }, []);

    return (
        <>
            <Header />
            <section className="App h-screen w-full flex justify-center items-center bg-green-100">
                <div className="mt-16 flex flex-col items-center justify-center w-10/12 max-w-screen-2xl h-4/5 rounded-md bg-white pb-8" >
                    <h1 className="text-5xl mb-8 mt-4">Booking</h1>
                    <div className="w-11/12 relative text-gray-600 h-5/6">
                        <div className="bg-white sticky top-0 p-2">
                            <input className="sticky top-0 w-1/2 border-2 border-gray-300 bg-white h-10 px-5 pr-16 rounded-lg text-sm focus:outline-none"
                                type="search" name="search" placeholder="Search" />
                            <button type="submit" className="absolute right-1/4 -top-1 p-0 mt-5 mr-4">
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                                </svg>
                            </button>
                        </div>
                        <div className="mt-8 flex flex-col items-center pb-4 overflow-auto h-5/6">
                            {housings.map(housing => (
                                <a key={housing.id} href={`/House/${housing.id}`} className="w-11/12 m-3">
                                    <div className="flex border-2 p-4 border-green-200 rounded-md bg-green-50 h-56">
                                        {housing.images.length !== 0 ?
                                            <img className="w-3/12" src={housing.images[0].imageAddress} alt="" />
                                            :
                                            <div className="flex h-full bg-gray-200 w-60 justify-center items-center">
                                                <svg xmlns="http://www.w3.org/2000/svg" className="h-16 w-16" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z" />
                                                </svg>
                                            </div>
                                        }
                                        <div className="pl-4 flex-col w-9/12 justify-start text-justify">
                                            <h1 className="text-2xl border-b-2 border-green-500">{housing.title}</h1>
                                            <p className="h-5/6 text-lg overflow-hidden">{housing.description}</p>
                                        </div>
                                    </div>
                                </a>
                            ))}
                        </div>
                    </div>
                </div>
            </section>
        </>
    );
}

export default Booking