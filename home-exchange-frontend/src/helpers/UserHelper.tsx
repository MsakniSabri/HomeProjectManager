import axios from "axios";
import { defaultUser, IRegisterDto, IUserDto } from "./interfaces/interfacesDTO";

export const getUser = async () => {
    let user: IUserDto = defaultUser;

    await axios
        .get<IUserDto>('http://localhost:8080/me', { withCredentials: true })
        .then(response => {
            user = response.data;
            console.log(user)
        })

    return user;
}