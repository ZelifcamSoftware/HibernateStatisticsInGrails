package queryperformance

class BootStrap {
    def bootstrapService

    def init = { servletContext ->
        //Create document statuses
        bootstrapService.createTestData()
    }
    def destroy = {
    }
}
