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
  "price": number
}

export interface MenuCategory {
  "name": string,
  "entries": Dish[]
}
