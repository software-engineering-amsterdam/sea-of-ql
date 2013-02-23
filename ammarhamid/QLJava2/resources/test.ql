form TestQL
{
    "First name" name: string

    "Did you sell a house in 2010?" hasSoldHouse: boolean
    if(hasSoldHouse)
    {
        "House price?" housePrice: integer
    }
    else
    {
        "Definitely sure?" houseSure: boolean
    }

    "Are you married?" married: boolean
    if(married)
    {
        "When is that?" when: string
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean
    if(hasSoldCar || married)
    {
        "Car price?" carPrice: integer
    }
    else
    {
        "Absolutely sure?" carSure: boolean
    }

}
