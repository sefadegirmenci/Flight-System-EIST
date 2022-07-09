export interface CardEntry {
  "title": string,
  "subTitle"?: string,
  "imageUrl": string,
  "imageAlt"?: string,
  "text"?: string,
  "routerLink": string
}

export interface Theme {
  "backgroundColor": string,
  "buttonColor": string,
  "headingColor": string,
  "label": string,
  "value": string
}

export interface Dish {
  "name": string,
  "price": number,
  "category": string,
  "imageUrl": string
}

export interface MenuCategory {
  "name": string,
  "entries": Dish[]
}

export interface Movie {
  "id": string,
  "name": string,
  "description": string,
  "thumbnailURL": string
}

export interface Airport {
  "id": string,
  "airportCode": string,
  "city": string
}

export interface Flight {
  "id": string,
  "flightNumber": number,
  "arrivalAirport": Airport,
  "departureAirport": Airport
}
