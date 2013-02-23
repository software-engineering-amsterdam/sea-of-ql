form TestQL
{
    "What is your name?" name: string
    "How old are you?" age: integer

    "Did you sell a house in 2010?" hasSoldHouse: boolean
    if(hasSoldHouse)
    {
        "The house price" housePrice: money
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
