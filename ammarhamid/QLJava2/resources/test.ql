form test
{
    "First name" name: string
    "Did you sell a house in 2010?" hasSoldHouse: boolean

    if(hasSoldHouse)
    {
        "What is the price?" housePrice: integer
    }

    "Did you sell a car in 2010?" hasSoldCar: boolean
}
