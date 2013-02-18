form test
{
    "First name" name: string
    "Did you sell a house in 2010?" hasSoldHouse: boolean

    if(hasSoldHouse)
    {
        "House price?" housePrice: integer
    }
    else
    {
        "Definitely sure?" sure: boolean
    }

    "Are you married?" married: boolean

    if(married)
    {
        "When is that?" married: string
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean

    if(hasSoldCar)
    {
        "Car price?" housePrice: integer
    }
    else
    {
        "Absolutely sure?" sure: boolean
    }


}
