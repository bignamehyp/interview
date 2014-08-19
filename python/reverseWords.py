class ReverseWords:
	def reverseWords(self,s):
		word = s.split()
		solns = ""
		prefix = ""
		for word in reversed(words):
			solns+= prefix + word
			prefix = " "
		return solns
