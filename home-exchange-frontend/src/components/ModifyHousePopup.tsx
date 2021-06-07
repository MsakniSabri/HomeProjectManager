import { useState } from "react";
import { updateHouse } from "../helpers/HousesHelper";
import { IHousingDto } from "../helpers/interfaces/interfacesDTO"

interface IProps {
    housing: IHousingDto,
    setHousing: (housing: IHousingDto) => void;
    setIsPopupOpen: (boolean: boolean) => void;
}

const ModifyHousePopup = (props: IProps) => {

    const [title, setTitle] = useState<string>(props.housing.title)
    const [description, setDescription] = useState<string>(props.housing.description)

    const closePopup = () => {
        let housing = props.housing;
        props.setIsPopupOpen(false);
        housing.title = title;
        housing.description = description;

        updateHouse(housing)
            .then(response => props.setHousing(response))
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
                            <label htmlFor="title" className="text-sm block font-bold  pb-2">TITLE</label>
                            <input type="text" name="title" value={title} placeholder="title" required id="" onChange={(e: React.FormEvent<HTMLInputElement>) => setTitle(e.currentTarget.value)} className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                        <div className="px-4 pb-4 my-4 h-4/5">
                            <label htmlFor="description" className="text-sm block font-bold  pb-2">LAST NAME</label>
                            <textarea name="description" value={description} placeholder="Your description" required id="" onChange={(e: React.ChangeEvent<HTMLTextAreaElement>) => setDescription(e.currentTarget.value)} className="h-full shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline border-blue-300 " />
                        </div>
                    </div>
                    <div className="flex justify-around mt-10">
                        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="button" onClick={closePopup}>Register</button>
                    </div>
                </form>
            </div>
        </section>
    )

}

export default ModifyHousePopup