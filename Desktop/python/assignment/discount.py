
price = input(" Enter the price ")

discount = input(" Enter your discount percentage ")

discount_price = (int(price) / 100) * int(discount)

price_after_discount = int(price) - discount_price

print("The price after discount is " + str(price_after_discount))