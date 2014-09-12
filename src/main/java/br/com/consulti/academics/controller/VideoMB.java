/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.consulti.academics.controller;

import br.com.consulti.academics.business.VideoBusiness;
import br.com.consulti.academics.model.Video;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import org.primefaces.event.FileUploadEvent;  
import org.primefaces.model.UploadedFile; 

/**
 *
 * @author Valter
 */
@Named
@SessionScoped
public class VideoMB implements Serializable {

    @Inject
    VideoBusiness business ;
    
    @Inject
    Video video;
    List<Video> videos;
    
    
      public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext context = FacesContext.getCurrentInstance();
        UploadedFile file = event.getFile();	
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        video.setUrlVideo(null);
    }  
    
    public List<Video> listarTodosVideos() {
        return business.getAll();
    }

    public VideoBusiness getBusiness() {
        return business;
    }

    public void setBusiness(VideoBusiness business) {
        this.business = business;
    }

    public Video getVideo() {

        if (this.video == null) {
            video = new Video();
        }
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public List<Video> getVideos() {
        if (videos == null) {
            videos = listarTodosVideos();
        }
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
    public void obterPorId( Long id){
        business.obterPorID(id);
    }
    
}
