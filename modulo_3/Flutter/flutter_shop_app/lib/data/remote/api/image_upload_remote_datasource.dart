import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../core/error/api_exception.dart';
import 'dio_client.dart';

abstract class ImageUploadRemoteDatasource {
  Future<String> uploadProductImage(int productId, String filePath);
  Future<String> uploadAvatar(int userId, String filePath);
}

class ImageUploadRemoteDatasourceImpl implements ImageUploadRemoteDatasource {
  final Dio _dio;
  ImageUploadRemoteDatasourceImpl(this._dio);

  @override
  Future<String> uploadProductImage(int productId, String filePath) async {
    try {
      final file = await MultipartFile.fromFile(
        filePath,
        filename: Uri.file(filePath).pathSegments.last,
      );
      final data = FormData.fromMap({'image': file});
      final res = await _dio.post(
        '/products/$productId/upload-image/',
        data: data,
        options: Options(contentType: 'multipart/form-data'),
      );
      return (res.data as Map<String, dynamic>)['image_url'] as String;
    } on DioException catch (e) {
      throw ApiException.fromDioError(e);
    }
  }

  @override
  Future<String> uploadAvatar(int userId, String filePath) async {
    try {
      final file = await MultipartFile.fromFile(
        filePath,
        filename: Uri.file(filePath).pathSegments.last,
      );
      final data = FormData({'image': file});
      final res = await _dio.post(
        '/users/$userId/upload-avatar/',
        data: data,
        options: Options(contentType: 'multipart/form-data'),
      );
      return (res.data as Map<String, dynamic>)['avatar_url'] as String;
    } on DioException catch (e) {
      throw ApiException.fromDioError(e);
    }
  }
}

final imageUploadDatasourceProvider = Provider<ImageUploadRemoteDatasource>((ref) {
  return ImageUploadRemoteDatasourceImpl(ref.watch(dioProvider));
});
