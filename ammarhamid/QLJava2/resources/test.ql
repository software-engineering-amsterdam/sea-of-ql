form test
{
    "First name" name: string
    "Did you sell a house in 2010?" hasSoldHouse: boolean

    if(hasSoldHouse)
    {
        "What is the price?" housePrice: integer
    }
    else
    {
        "Are you sure?" sure: boolean
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean
}
