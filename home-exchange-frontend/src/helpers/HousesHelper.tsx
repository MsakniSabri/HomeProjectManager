import axios from 'axios';
import { defaultHousing, IHousingDto } from './interfaces/interfacesDTO';

export const getAllHouses = async () => {
    let Housings: IHousingDto[] = [];

    await axios
        .get<IHousingDto[]>("http://localhost:8080/housings")
        .then(response => {
            Housings = response.data;
        })

    return Housings;
}

export const getMyHouses = (id: number) => {
    let Housings: IHousingDto[] = [];

    axios
        .get<IHousingDto[]>('http://localhost:8080/housings/user/' + id)
        .then(response => {
            Housings = response.data;
        })

    return Housings;
}

export const getHouseById = async (id: number) => {
    let Housing: IHousingDto = defaultHousing;

    await axios
        .get<IHousingDto>('http://localhost:8080/housings/' + id)
        .then(response => {
            Housing = response.data;
        })

    return Housing;
}