/**
 * 
 */
package com.governmentcio.dmp.dao;

import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author <a href=mailto:support@governmentcio.com>support</a>
 *
 */
@JsonSerialize(using = AccessCredentialDaoSerializer.class)
public class AccessCredentialDao {

	private String accessCode;

	/**
	 * @param userName
	 * @param password
	 */
	public AccessCredentialDao() {
		super();

		accessCode = UUID.randomUUID().toString();

	}

	/**
	 * @return the accessCode
	 */
	public String getAccessCode() {
		return accessCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCode == null) ? 0 : accessCode.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		AccessCredentialDao other = (AccessCredentialDao) obj;
		if (accessCode == null) {
			if (other.accessCode != null)
				return false;
		} else if (!accessCode.equals(other.accessCode))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessCredentialDao [accessCode=").append(accessCode).append("]");
		return builder.toString();
	}

}
