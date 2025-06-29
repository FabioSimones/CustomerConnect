package dev.fabiosimones.customerconnect.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponse paginationResponse) {
}
