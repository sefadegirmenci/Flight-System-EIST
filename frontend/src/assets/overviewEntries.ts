import {CardEntry} from "../app/types/interfaces";

export const overviewEntries: CardEntry[] = [
  {
    "title": "Flight list",
    "subTitle": "Everything I have saved to my flight list",
    "imageUrl": "https://static01.nyt.com/images/2021/02/26/travel/26United-plane-explainer1/26United-plane-explainer1-mediumSquareAt3X.jpg",
    "text": "Contains a list of all outstanding and absolved flights including their departure and arrival time. Also food and drink pre-orders can be performed from this view",
    "routerLink": "saved"
  },
  {
    "title": "Flight search",
    "subTitle": "If I want to go somewhere",
    "imageUrl": "https://ichef.bbci.co.uk/news/976/cpsprodpb/1589A/production/_123281288_gettyimages-1197444137.jpg",
    "text": "Contains search and filter functionalities in order to find the optimal flight",
    "routerLink": "search"
  }
]
