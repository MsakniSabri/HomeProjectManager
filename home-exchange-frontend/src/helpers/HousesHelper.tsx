import axios from 'axios';
import { IHousingDto } from './interfaces/interfacesDTO';

export const getAllHouses = () => {
    let defaultHousings: IHousingDto[] = [];

    axios
        .get<IHousingDto[]>("http://localhost:8080/housings")
        .then(response => {
            defaultHousings = response.data;
        })

    return defaultHousings;
}