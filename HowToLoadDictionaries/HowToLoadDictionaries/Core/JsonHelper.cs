using System.IO;
using Newtonsoft.Json;

namespace HowToLoadDictionaries.Core
{
    public static class JsonHelper
    {
        public static T DeserializeFromFile<T>(string filePath, JsonSerializerSettings settings = null)
        {
            using (var fileStream = File.OpenRead(filePath))
            {
                using (var streamReader = new StreamReader(fileStream))
                {
                    using (var reader = new JsonTextReader(streamReader))
                    {
                        var serializer = settings == null ? JsonSerializer.Create() : JsonSerializer.Create(settings);
                        return serializer.Deserialize<T>(reader);
                    }
                }
            }
        }
    }
}