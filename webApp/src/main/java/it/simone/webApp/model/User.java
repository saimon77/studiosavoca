package it.simone.webApp.model;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome, cognome, mail;

	@Column
	private Timestamp data_creazione;

	public static Class getType(String field) {
		Field f = null;
		try {
			f = User.class.getDeclaredField(field);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f.getType();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome
	 *            the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + "]";
	}

	/**
	 * @return the data_creazione
	 */
	public Timestamp getData_creazione() {
		return data_creazione;
	}

	/**
	 * @param data_creazione
	 *            the data_creazione to set
	 */
	public void setData_creazione(Timestamp data_creazione) {
		this.data_creazione = data_creazione;
	}
}
