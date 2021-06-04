import React, { useEffect, useState } from "react";
import { getMyHouses } from "../helpers/HousesHelper";
import { IHousingDto } from "../helpers/interfaces/interfacesDTO";
import Header from "./Header";

const MyHousings = (props: any) => {

    const [housings, setHousings] = useState<IHousingDto[]>([])

    useEffect(() => {
        setHousings(getMyHouses(props.id))
        console.log("get houses")
    }, []);

    const housingsTest: IHousingDto[] = [{
        id: 5,
        description: "Ortembach: Maison individuelle accueillante, simple, rénovée en 2013. À 2 km du centre, situation tranquille quartier résidentiel, à 2.5 km de la mer. En été : Plage de sable, avec installations de plage, adaptée pour les enfants. Crique pour les baignades. Parc aquatique 'Aqualandia' à 25 km. Port de plaisance Club Naútico.",
        title: "Villa bord de mer",
        userId: 1,
        properties: [
            { id: 1, description: "pas d'animaux de compagnie" },
            { id: 2, description: "pas d'enfants" },
            { id: 3, description: "pas de fêtes" },
            { id: 3, description: "pas de drogues" },
            { id: 3, description: "pas d'alcool" },
            { id: 3, description: "pas d'alcool" },
            { id: 3, description: "pas d'alcool" },
        ],
        images: [
            { id: 1, imageAddress: "https://www.villas.fr/upload/villa-image/4211/medium/i5348_1479734879.jpg", housingId: 2 },
            { id: 2, imageAddress: "https://www.villas.fr/upload/villa-image/4211/medium/i5394_1479734884.jpg", housingId: 2 },
            { id: 3, imageAddress: "https://www.villas.fr/upload/villa-image/4211/medium/i5373_1479734883.jpg", housingId: 2 },
            { id: 4, imageAddress: "https://www.villas.fr/upload/villa-image/4211/medium/i5352_1479734880.jpg", housingId: 2 },
            { id: 5, imageAddress: "https://www.villas.fr/upload/villa-image/4211/medium/i5359_1479734880.jpg", housingId: 2 }
        ]
    }]
    
    return(
        <>
            <Header />
            <section className="App h-screen w-full flex justify-center items-center bg-green-100 relative">
                <div className="mt-16 flex flex-col items-center justify-center w-10/12 max-w-screen-2xl h-4/5 rounded-md bg-white pb-8" >
                    <h1 className="text-5xl mb-8 mt-4">My Housings</h1>
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
                            <button type="submit" className="p-1 mb-3 w-11/12 flex items-center justify-start bg-green-50 rounded-full border-2 border-green-200">
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-12 w-12" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                                <p className="pl-4 text-xl">Add a house</p>
                            </button>
                            {housingsTest.map(housing => (
                                <a href={`/House/${housing.id}`} className="w-11/12 m-3">
                                    <div className="flex border-2 p-4 border-green-200 rounded-md bg-green-50 h-56">
                                        <img className="w-3/12" src="https://www.igc-construction.fr/sites/default/files/2019-11/maison-de-ville-avec-piscine-a-bordeaux.jpg" alt="" />
                                        <div className="pl-4 flex-col w-9/12 justify-start text-justify">
                                            <h1 className="text-2xl border-b-2 border-green-500">{housing.title}</h1>
                                            <p className="h-5/6 text-lg overflow-hidden">{housing.description}</p>
                                        </div>
                                        <div className="pl-4 flex-col justify-end">
                                            <button type="submit">
                                                <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                                </svg>
                                            </button>
                                        </div>
                                    </div>
                                </a>
                            ))}
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}

export default MyHousings;