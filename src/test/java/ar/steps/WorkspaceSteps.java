package ar.steps;


import api.model.Project.ProjectResponse;
import ar.validator.ProjectValidator;
import ar.validator.WorkspaceValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;
import services.ProjectIDService;
import services.ProjectService;


public class WorkspaceSteps extends PageSteps {

    ProjectValidator validator = new ProjectValidator();
    @Given("Mi cuenta creada en clockify y mi X-Api-Key geneada")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGeneada() {
        BaseService.API_KEY.set("ZDg1ZGMxNzAtYzEwZi00Y2QyLTgzMzUtMjU5MzNmYmIxZGY1");
    }

    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @Given("X-Api-Key invalido")
    public void xApiKeyInvalido() {
        BaseService.API_KEY.set("NDRmZWUwYzEtOTZhMS00NDk5LWJkZWItY2FiNmY1MjQ3NGN");
    }


    @And("^Tengo el ID de un proyecto (.*)$")
    public void idProj(String id){
        ProjectService.ID.set(id);
    }

    @Given("El ID de un proyecto (.*)$")
    public void idProject(String id){
      ProjectResponse[] idProj = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
      for (int i=0;i < idProj.length;i++){
          if(idProj[i].getId().equals(id)){
              ProjectIDService.ID.set(id);
          }
      }

    }

    @And("un nombre '(.*)'")
    public void unNombreName(String name) {
        ProjectIDService.NAME.set(name);
    }

    @Then("se valida que el nombre '(.*)' haya sido cambiado")
    public void validarNombre(String name){
        validator.validateNombre(name);

    }


}
