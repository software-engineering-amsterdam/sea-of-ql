form TestQL
{
    "What is your name?" name: string
    "How old are you?" age: integer

    "Did you sell a house in 2010?" hasSoldHouse: boolean
    if(hasSoldHouse)
    {
        "The house price when you sold it" houseSoldPrice: money
        "The house price when you bought it" houseBoughtPrice: money
        "Price residue " valueResidue: money(houseSoldPrice-houseBoughtPrice)
        "Villa price " villaPrice: money
        "Total money residue + villaPrice" total: money(valueResidue+villaPrice)
    }
    else
    {
        "Definitely sure?" houseSure: boolean
    }

    "Are you married?" married: boolean
    if(married)
    {
        "What is your wife's name?" wifeName: string
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean
    if(hasSoldCar || married)
    {
        "The car price" carPrice: money
    }
    else
    {
        "Absolutely sure?" carSure: boolean
    }

}
