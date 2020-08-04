//package br.com.ximenes.simpleproject.model;
//
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Transient;
//
//import org.hibernate.annotations.Type;
//
//import br.com.caelum.vraptor.observer.upload.UploadedFile;
//import br.com.jvlabs.exception.BusinessException;
//import br.com.jvlabs.util.DateUtils;
//import br.com.jvlabs.util.FormatterString;
//
//@Entity(name="IMAGEM")
//public class Imagem extends Entidade implements Serializable{
//	private static final String MESSAGE_IMAGE_NOT_SUPORT = "O arquivo n&atilde;o &eacute; uma imagem suportada!";
//	public static final String IMAGE_NOT_AVAILABLE = "image_not_available.gif";
//	private static final long serialVersionUID = 1L;
//
//	@Column(nullable=false, length=200)
// 	private String url;
//
//	@Transient
//	private UploadedFile upload;
//
//	@Type(type="true_false")
//	private Boolean principal = Boolean.FALSE;
//
//	public Imagem() {
//	}
//
//	public Imagem(String url) throws IllegalArgumentException, BusinessException {
//		super();
//		setUrl(url);
//	}
//	public Imagem(UploadedFile upload) throws IllegalArgumentException, BusinessException {
//		super();
//		setUrl(upload.getFileName());
//		renameImageAddDate();
//		this.upload = upload;
//		this.principal = false;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Imagem other = (Imagem) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//	
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) throws IllegalArgumentException, BusinessException {
//		url = url.toLowerCase();
//
//		url = new FormatterString().toString(url)
//									  .removeAccents()
//									  .removeCharacters("-")
//									  .removeCharacters(",")
//									  .removeSpace()
//									  .formatString();
//		if(!isTypeSupported(url))
//			throw new BusinessException(MESSAGE_IMAGE_NOT_SUPORT);
//		this.url = url;
//	}
//
//	public String toString() {
//		return url;
//	}
//
//	public UploadedFile getUploadFile() {
//		return upload;
//	}
//
//	public void gsetUploadFile(UploadedFile upload) {
//		this.upload = upload;
//	}
//
//	public Boolean isPricipal(){
//		return principal == null ? false : true;
//	}
//
//	public void setPrincipal(Boolean principal) {
//		if(principal == null)
//			principal = false;
//		this.principal = principal;
//	}
//
//	public UploadedFile getUpload() {
//		return upload;
//	}
//
//	public void setUpload(UploadedFile upload) {
//		this.upload = upload;
//	}
//
//	public Boolean getPrincipal() {
//		return principal;
//	}
//	
//}