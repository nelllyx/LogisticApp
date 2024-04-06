INVESTMENT = 1000

ANNUAL_RATE = 7 / 100

after_ten_years = INVESTMENT * (( 1 + ANNUAL_RATE) ** 10)

after_twenty_years = INVESTMENT * (( 1 + ANNUAL_RATE) ** 20)

after_thirty_years = INVESTMENT * (( 1 + ANNUAL_RATE) ** 30)

print(f"The amount of deposit after 10 years is: ${after_ten_years:,.2f}")

print(f"The amount of deposit after 20 years is: ${after_twenty_years:,.2f}")

print(f"The amount of deposit after 30 years is: ${after_thirty_years:,.2f}")
