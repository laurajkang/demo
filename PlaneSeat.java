package laura.demo;

/**
 * Plane Seat Allocation 
 * @author Laura J Kang
 * @Date Aug 4, 2021
 * 
 * @Desc An airplane has N rows and it has 10 seats numbered from A to K as A,B,C,D,E,F,G,H,J,K ( I is not in there).  
 *  	 ABC form one column, DEFG form second column and HJK form third column: 
 *  					A B C      D E F G      H J K
 *  
 * Given number of rows as N and S represents the seats reserved in the above mentioned format, find the max number of ways a family 
 *  of 4 members can be allocated. Family members should be allocated consecutively.  C and D are not consecutive seats, same for G and H.
 *  
 *  Given a string S representing the reserved seats. Seats allocated are represented in S as “1A 2F 1K” separated by space. Your task is 
 *  to allocate seats for as many four-person families as possible. A four-person family occupies four seats in one row, that are next to 
 *  each other – seats across an aisle (such as 2C and 2D) are not considered to be next to each other. It is permissible for the family to
 *  be separated by an aisle, but in this case exactly two people have to sit on each side of the aisle. Obviously, no seat can be 
 *  allocated to more than one family.
 *   
 *  class Solution {
 *     public int solution(int N, String S) {
 *     
 *       }
 *   }
 */

import java.util.*;

public class PlaneSeat {


	/**
	 * Build a map for the seats of "A,B,C,D,E,F,G,H,J,K" to be mapped to positions between 0-9
	 */
	private static Map<String,Integer> seatMap = new HashMap<String,Integer>();
	static {
		seatMap.put("A", 0);
		seatMap.put("B", 1);
		seatMap.put("C", 2);
		seatMap.put("D", 3);
		seatMap.put("E", 4);
		seatMap.put("F", 5);
		seatMap.put("G", 6);
		seatMap.put("H", 7);
		seatMap.put("J", 8);
		seatMap.put("K", 9);;
	}
	

	public static void main(String[] args) {
		System.out.println("There are " + solution(2, "1A 2F 1C") + " way(s) to assign the family of 4.");
	}


	/**  Get the number of ways that the family of 4 can be seated
	 * 
	 * @param N -- number of rows in the air plane
	 * @param S -- Seats allocated in the format of “1A 2F 1K” separated by space
	 * @return -- number of ways to allocate family of 4 seating consecutively 
	 * 
	 * Time Complexity O(n)
	 */
	public static int solution(int N, String S) {
		if (( N < 1 ) || null == S )
			return 0;

		if (S.length() == 0) 
			return N*2;

		int result = 0;

		// 1 - build an array with all the seats in the plane
		// value = 1 taken
		//       = 0 available 
		int[][] seats = new int[N][10];
		String taken[] = S.split(" ");
		for ( String seat: taken ) 
		{
			int row = Integer.valueOf(seat.substring(0, 1)) - 1;
			if( row < N ) // to handle possible input cases with the reserved seats beyond row N
			{
				int pos = seatMap.get(seat.substring(1));
				seats[row][pos] = 1;
			}
		}

		// 2. count on each row how many seats can be assigned by the rule 
		for ( int row = 0; row < N; row ++) 
		{
			int BCDE = seats[row][1] + seats[row][2] + seats[row][3] + seats[row][4];
			int DEFG = seats[row][3] + seats[row][4] + seats[row][5] + seats[row][6] ;
			int FGHJ = seats[row][5] + seats[row][6] + seats[row][7] + seats[row][8];
			if (BCDE == 0  || DEFG == 0 || FGHJ == 0)
			{
				result ++;

				if (BCDE == 0 && FGHJ == 0) 
					result ++;
			}
		}

		return result;
	}

}

