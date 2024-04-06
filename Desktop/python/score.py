NUMBER_OF_STUDENT = 10

total_score = 0

for student in range(10):

	score = int(input('Enter your score: '))

	total_score += score

average = total_score/NUMBER_OF_STUDENT

print(f"The total scores of student is {total_score}")

print(f"The average score of student is {average}")
