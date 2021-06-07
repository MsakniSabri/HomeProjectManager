import axios from 'axios';
import { defaultHousing, ICreateHousingDto, IHousingDto } from './interfaces/interfacesDTO';

export const getAllHouses = async () => {
    let Housings: IHousingDto[] = [];

    await axios
        .get<IHousingDto[]>("http://localhost:8080/housings")
        .then(response => {
            Housings = response.data;
        })

    return Housings;
}

export const getMyHouses = async (id: number) => {
    let Housings: IHousingDto[] = [];

    await axios
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

export const createHouse = async (house: ICreateHousingDto) => {
    let houseId = 0;

    await axios
        .post<IHousingDto>("http://localhost:8080/housings", house)
        .then(response => {
            console.log("created", response.data)
            houseId = response.data.id;
        })

    return houseId;
}

export const updateHouse = async (house: IHousingDto) => {
    let housing: IHousingDto = defaultHousing;

    await axios
        .put("http://localhost:8080/housings", house)
        .then(response => {
            console.log("updated", response.data)
            housing = response.data
        })
    
        return housing;
}

export const DeleteHouseById = async (id: number) => {

    await axios
        .delete('http://localhost:8080/housings/' + id)
}