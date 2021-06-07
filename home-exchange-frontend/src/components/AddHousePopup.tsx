import { useState } from "react";
import { Redirect } from "react-router";
import { createHouse } from "../helpers/HousesHelper";
import { IHousingDto, IImageDto, IPropertieDto, ICreateHousingDto } from "../helpers/interfaces/interfacesDTO"
import House from "./House";

interface IProps {
    setIsPopupOpen: (boolean: boolean) => void;
    userId: number;
}

const AddHousePopup = (props: IProps) => {

    const [title, setTitle] = useState<string>("")
    const [description, setDescription] = useState<string>("") 
    const [isCreated, setCreated] = useState<boolean>(false)
    const [houseIdCreated, setHouseIdCreated] = useState<number>(0)

    const closePopup = () => {
        const userId = props.userId;
        const images: IImageDto[] = [];
        const properties: IPropertieDto[] = [];
        const house: ICreateHousingDto = {description, title, userId, images, properties};
        createHouse(house)
            .then(res => {
                setHouseIdCreated(res)
                setCreated(true)
                console.log("house created")
            })
    }

    return (
        <section className="App h-screen w-full flex justify-center absolute top-0 right-0 items-center bg-green-100 bg-opacity-70">
            <div className="w-full h-1/2 max-w-xl bg-gray-800">
                <form action="" className="h-full bg-white shadow-md rounded px-8 py-8 pt-8">
                    <div className="flex flex-col h-4/5">
                        <div className="px-4 pb-4 h-1/5">
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">TITLE</label>
                            <input type="text" name="title" value={title} placeholder="title" required id="" onChange={(e:React.FormEvent<HTMLInputElement>) => setTitle(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 my-4 h-4/5">
                            <label htmlFor="description" className="text-sm block font-bold  pb-2">LAST NAME</label>
                            <textarea name="description" value={description} placeholder="Your description" required id="" onChange={(e: React.ChangeEvent<HTMLTextAreaElement>) => setDescription(e.currentTarget.value)} className="h-full shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                    </div>
                    <div className="flex justify-around mt-10">
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button" onClick={closePopup}>Create</button>
                    </div>
                </form>
            </div>
            {isCreated && <Redirect to={"/House/" + houseIdCreated} />}
        </section>
    )
}

export default AddHousePopup