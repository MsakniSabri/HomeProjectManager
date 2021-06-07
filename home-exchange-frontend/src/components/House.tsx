import React from "react";
import { useState, useEffect } from 'react';
import { useParams } from "react-router";
import { Link } from "react-router-dom";
import { getAllHouses, getHouseById } from "../helpers/HousesHelper";
import { IHousingDto, defaultHousing } from "../helpers/interfaces/interfacesDTO";
import Header from "./Header";
import ModifyHousePopup from "./ModifyHousePopup";

interface IProps {
    userId: number;
}

const House = (props: IProps) => {

    const params: any = useParams();

    console.log(props.userId)

    const [isPopPupOpen, setPopUpOpen] = useState<boolean>(false)
    const [housing, setHousing] = useState<IHousingDto>(defaultHousing)

    useEffect(() => {
        getHouseById(params.id)
            .then(response => setHousing(response))
    }, []);

    const setIsPopUpOpen = () => {
        setPopUpOpen(true)
    }

    return (
        <>
            <Header />
            <section className="App h-screen w-full flex justify-center items-center bg-green-100">
                <div className="mt-16 flex flex-col items-center justify-center w-10/12 max-w-screen-2xl h-4/5 rounded-md bg-white pb-8" >
                    <div className="relative flex w-full justify-center">
                        <h1 className="text-5xl">{housing.title} {props.userId}</h1>
                        {housing.userId === props.userId &&
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
                        }
                    </div>
                    <div className="w-11/12 relative text-gray-600 h-5/6">
                        <div className="flex w-full my-6 h-2/5 overflow-auto">
                            {housing.images.length !== 0 ?
                                housing.images.map(image => (
                                    <img className="mr-8 mb-4" src={image.imageAddress} alt="" />
                                )) :
                                <div className="flex h-full bg-gray-200 w-60 justify-center items-center">
                                    <svg xmlns="http://www.w3.org/2000/svg" className="h-16 w-16" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z" />
                                    </svg>
                                </div>
                            }
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
                {isPopPupOpen && <ModifyHousePopup housing={housing} setHousing={setHousing} setIsPopupOpen={setPopUpOpen} />}
            </section>
        </>
    );
}

export default House