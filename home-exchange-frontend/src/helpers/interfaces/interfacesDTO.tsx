export interface IHousingDto {
    id: number;
    description: string;
    title: string;
    userId: number;
    properties: IPropertieDto[];
    user: IUserDto;
    images: IImageDto[];
}

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

export interface IPropertieDto {
    id: number;
    description: string;
}

export interface IImageDto {
    id: number;
    imageAddress: string;
    housingId: number;
}

export interface ICreateUserDto {
    id: number;
    email: string;
    password: string;
    phonNumber?: string;
    firstname: string;
    lastname: string;
}