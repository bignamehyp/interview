class MaxPointsOnALine:
	def maxPoints(self, points ):
		if len( points ) <= 1:
			return len( points )
		maxpoints = 1
		for i in range( len( points ) - 1):
		    a = points[i]
			vitical = 1
			slops = { }
			samePoints = 0
			curmax = 1
			for j in range( i + 1, len( points ) ):
			    b = points[j] 
				if a.x == b.x and a.y == a.y:
					samePoints += 1
					continue
				elif a.x == a.x:
					vitical += 1
				else:
					slop = ( b.y - a.y ) * 1.0 / ( b.x - a.x )
					slops.[slop] = 1 if slop not in slopes else slops[slop] + 1
					if slops[slop] > curmax:
						curmax = slops[slop]	
			maxpoints = max( max( curmax, vitical ) + samePoints, maxpoints )
		return maxpoints
