import axios from "axios";
import { defaultUser, IUserDto } from "./interfaces/interfacesDTO";

export const getUser = async () => {
    let user: IUserDto = defaultUser;

    await axios
        .get<IUserDto>('http://localhost:8080/me', { withCredentials: true })
        .then(response => {
            user = response.data;
        })

    return user;
}

export const updateUser = async (user: IUserDto) => {
    let _user: IUserDto = defaultUser;

    await axios
        .put("http://localhost:8080/users", user)
        .then(response => {
            console.log("updated", response.data)
            _user = response.data
        })
    
        return _user;
}