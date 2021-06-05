export interface IUserDto {
    id: number;
    email: string;
    phoneNumber?: string;
    firstname: string;
    lastname: string;
    profilePictureUrl?: string;
    admin: boolean;
    housings: IHousingDto[];
}

export interface IRegisterDto {
    email: string,
    password: string,
    phoneNumber?: string,
    firstname: string,
    lastname: string,
}

export const defaultUser: IUserDto = {
    id: 0, 
    email: '', 
    phoneNumber: '', 
    firstname: '', 
    lastname: '', 
    profilePictureUrl: '', 
    admin: false, 
    housings: []
}

export interface IHousingDto {
    id: number;
    description: string;
    title: string;
    userId: number;
    properties: IPropertieDto[];
    images: IImageDto[];
}

export const defaultHousing: IHousingDto = {
    id: 0,
    description: "",
    title: "",
    userId: 0,
    properties: [],
    images: [],
}

export interface IPropertieDto {
    id: number;
    description: string;
}

export interface IImageDto {
    id: number;
    imageAddress: string;
    housingId: number;
}