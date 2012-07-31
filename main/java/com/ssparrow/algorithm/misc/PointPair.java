/**
 * 
 */
package com.ssparrow.algorithm.misc;

/**
 * @author Philip
 *
 */
public class PointPair {
	private Point point1;
	private Point point2;
	
	
	/**
	 * @param point1
	 * @param point2
	 */
	public PointPair(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}


	/**
	 * @return the point1
	 */
	public Point getPoint1() {
		return point1;
	}


	/**
	 * @param point1 the point1 to set
	 */
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}


	/**
	 * @return the point2
	 */
	public Point getPoint2() {
		return point2;
	}


	/**
	 * @param point2 the point2 to set
	 */
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point1 == null) ? 0 : point1.hashCode());
		result = prime * result + ((point2 == null) ? 0 : point2.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointPair other = (PointPair) obj;
		if (point1 == null) {
			if (other.point1 != null)
				return false;
		} else if (!point1.equals(other.point1))
			return false;
		if (point2 == null) {
			if (other.point2 != null)
				return false;
		} else if (!point2.equals(other.point2))
			return false;
		return true;
	}
	
	
	
	
}
