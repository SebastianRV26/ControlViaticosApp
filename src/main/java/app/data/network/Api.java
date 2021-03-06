package app.data.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class exposes the server API to rest of the app.
 */
public class Api {

    private static Api instance;
    private static final String BASE_URL = "http://localhost:3000/";
    private Retrofit retrofit;

    // Services
    private BranchOfficeService branchOfficeService;
    private ResourceService resourceService;
    private ReasonService reasonService;
    private SupportTypeService supportTypeService;
    private ClientService clientService;
    private SupplierService supplierService;
    private TaskService taskService;
    private CostService costService;
    private EventService eventService;
    private VehicleService vehicleService;
    private ExpenseTypeService expenseTypeService;
    private TaskTypeService taskTypeService;

    /**
     * @return the unique instance of the API
     */
    public static synchronized Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    /**
     * Creates the retrofit instance and instantiates all the services.
     */
    private Api() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        branchOfficeService = retrofit.create(BranchOfficeService.class);
        resourceService = retrofit.create(ResourceService.class);
        reasonService = retrofit.create(ReasonService.class);
        supportTypeService = retrofit.create(SupportTypeService.class);
        clientService = retrofit.create(ClientService.class);
        supplierService = retrofit.create(SupplierService.class);
        taskService = retrofit.create(TaskService.class);
        costService = retrofit.create(CostService.class);
        eventService = retrofit.create(EventService.class);
        vehicleService = retrofit.create(VehicleService.class);
        expenseTypeService = retrofit.create(ExpenseTypeService.class);
        taskTypeService = retrofit.create(TaskTypeService.class);
    }

    // Services getters
    public ClientService getClientService() {
        return clientService;
    }

    public BranchOfficeService getBranchOfficeService() {
        return branchOfficeService;
    }

    public SupplierService getSupplierService() {
        return supplierService;
    }

    public SupportTypeService getSupportTypeService() {
        return supportTypeService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public ReasonService getReasonService() {
        return reasonService;
    }

    public TaskService getTaskService() {
        return taskService;
    }
    public CostService getCostService() {
        return costService;
    }

    public EventService getEventService() {
        return eventService;
    }
    
    public VehicleService getVehicleService() {
        return vehicleService;
    }

    public ExpenseTypeService getExpenseTypeService() {
        return expenseTypeService;
    }

    public TaskTypeService getTaskTypeService() {
        return taskTypeService;
    }

}
