import React from "react";
import { useState, useEffect } from 'react';
import { useParams } from "react-router";
import { Link } from "react-router-dom";
import { getAllHouses, getHouseById } from "../helpers/HousesHelper";
import { IHousingDto, defaultHousing } from "../helpers/interfaces/interfacesDTO";
import Header from "./Header";
import ModifyHousePopup from "./ModifyHousePopup";

const House = () => {

    const params: any = useParams();

    
    const [isPopPupOpen, setPopUpOpen] = useState<boolean>(false)

    /*useEffect(() => {
        setHousing(getHouseById(params.id))
    }, []);*/

    const setIsPopUpOpen = () => {
        setPopUpOpen(true)
    }

    const housingTest: IHousingDto = {
        id: 2,
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
    }

    const [housing, setHousing] = useState<IHousingDto>(housingTest)

    return (
        <>

            <Header />
            <section className="App h-screen w-full flex justify-center items-center bg-green-100">
                <div className="mt-16 flex flex-col items-center justify-center w-10/12 max-w-screen-2xl h-4/5 rounded-md bg-white pb-8" >
                    <div className="relative flex w-full justify-center">
                        <h1 className="text-5xl">{housing.title}</h1>
                        <div className="absolute flex w-16 justify-around right-16 top-2">
                            <button type="submit">
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-10 w-10" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                </svg>
                            </button>
                            <button type="submit" onClick={setIsPopUpOpen}>
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-10 w-10" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div className="w-11/12 relative text-gray-600 h-5/6">
                        <div className="flex w-full my-6 h-2/5 overflow-auto">
                            {housing.images.map(image => (
                                <img className="mr-8 mb-4" src={image.imageAddress} alt="" />
                            ))}
                        </div>
                        <div className="flex flex-col items-start text-justify w-full h-2/5">
                            <h1 className="text-3xl mb-8 mt-4">Description :</h1>
                            <p className="text-xl">{housing.description}</p>
                        </div>
                        <div className="flex h-1/5 overflow-auto pt-8">
                            <button type="submit" className="p-1 px-4 mb-3 flex items-center justify-start bg-green-50 rounded-full border-2 border-green-200">
                                <svg xmlns="http://www.w3.org/2000/svg" className="h-10 w-10" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
                                </svg>
                                <p className="whitespace-nowrap pl-4 text-xl">Add a propertie</p>
                            </button>
                            {housing.properties.map(propertie => (
                                <Link className="whitespace-nowrap p-1 px-4 mb-3 mx-2 text-xl flex items-center justify-start bg-green-50 rounded-full border-2 border-green-200" to="/">
                                    {propertie.description}
                                </Link>
                            ))}
                        </div>
                    </div>
                </div>
                {isPopPupOpen && <ModifyHousePopup housing={housing} setHousing={setHousing} setIsPopupOpen={setPopUpOpen}/>}
            </section>
        </>
    );
}

export default House