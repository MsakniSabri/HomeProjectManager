import axios from 'axios';
import { defaultHousing, IHousingDto } from './interfaces/interfacesDTO';

export const getAllHouses = () => {
    let Housings: IHousingDto[] = [];

    axios
        .get<IHousingDto[]>("http://localhost:8080/housings")
        .then(response => {
            Housings = response.data;
        })

    return Housings;
}

export const getMyHouses = (id: number) => {
    let Housings: IHousingDto[] = [];

    axios
        .get<IHousingDto[]>('http://localhost:8080/housings/user/' + {id})
        .then(response => {
            Housings = response.data;
        })

    return Housings;
}

export const getHouseById = (id: number) => {
    let Housing: IHousingDto = defaultHousing;

    axios
        .get<IHousingDto>('http://localhost:8080/housings/1' + {id})
        .then(response => {
            Housing = response.data;
        })

    return Housing;
}